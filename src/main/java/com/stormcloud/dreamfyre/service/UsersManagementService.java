package com.stormcloud.dreamfyre.service;

import com.stormcloud.dreamfyre.config.JWTAuthFilter;
import com.stormcloud.dreamfyre.dto.ReqRes;
import com.stormcloud.dreamfyre.entity.DreamfyreUser;
import com.stormcloud.dreamfyre.entity.DreamfyreUserPrimaryKey;
import com.stormcloud.dreamfyre.repository.UsersRepo;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsersManagementService {

	@Autowired
	private UsersRepo usersRepo;
	@Autowired
	private JWTUtils jwtUtils;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public ReqRes register(ReqRes registrationRequest) {
		ReqRes resp = new ReqRes();

		try {
			UUID dfid = UUID.randomUUID();
			DreamfyreUserPrimaryKey userPK = new DreamfyreUserPrimaryKey(dfid);
			DreamfyreUser user = new DreamfyreUser(userPK, passwordEncoder.encode(registrationRequest.getPassword()),
					registrationRequest.getFirstName(), registrationRequest.getLastName(),
					registrationRequest.getMiddleName(), registrationRequest.getKnownAs(),
					registrationRequest.getEmail(), registrationRequest.getContactPhoneNumber(),
					registrationRequest.getGender(), registrationRequest.getDateOfBirth());
			user.setRole(registrationRequest.getRole());
			user.setWelcomeMailSent(false);
			user.setActiveAccount(true);
			DreamfyreUser userResult = usersRepo.save(user);

			resp.setOurUsers((userResult));
			resp.setMessage("User Saved Successfully");
			resp.setStatusCode(200);

		} catch (Exception e) {
			resp.setStatusCode(500);
			resp.setError(e.getMessage());
		}
		return resp;
	}

	public ReqRes login(ReqRes loginRequest) {
		ReqRes response = new ReqRes();
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
			var user = usersRepo.findByEmail(loginRequest.getEmail()).orElseThrow();
			var jwt = jwtUtils.generateToken(user);
			var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
			response.setStatusCode(200);
			response.setToken(jwt);
			response.setRole(user.getRole());
			response.setRefreshToken(refreshToken);
			response.setExpirationTime("24Hrs");
			response.setMessage("Successfully Logged In");

		} catch (Exception e) {
			response.setStatusCode(500);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	public ReqRes refreshToken(ReqRes refreshTokenReqiest) {
		ReqRes response = new ReqRes();
		try {
			String ourEmail = jwtUtils.extractUsername(refreshTokenReqiest.getToken());
			DreamfyreUser users = usersRepo.findByEmail(ourEmail).orElseThrow();
			if (jwtUtils.isTokenValid(refreshTokenReqiest.getToken(), users)) {
				var jwt = jwtUtils.generateToken(users);
				response.setStatusCode(200);
				response.setToken(jwt);
				response.setRefreshToken(refreshTokenReqiest.getToken());
				response.setExpirationTime("24Hr");
				response.setMessage("Successfully Refreshed Token");
			}
			response.setStatusCode(200);
			return response;

		} catch (Exception e) {
			response.setStatusCode(500);
			response.setMessage(e.getMessage());
			return response;
		}
	}

	public ReqRes getAllUsers() {
		ReqRes reqRes = new ReqRes();

		try {
			List<DreamfyreUser> result = usersRepo.findAll();
			if (!result.isEmpty()) {
				reqRes.setOurUsersList(result);
				reqRes.setStatusCode(200);
				reqRes.setMessage("Successful");
			} else {
				reqRes.setStatusCode(404);
				reqRes.setMessage("No users found");
			}
			return reqRes;
		} catch (Exception e) {
			reqRes.setStatusCode(500);
			reqRes.setMessage("Error occurred: " + e.getMessage());
			return reqRes;
		}
	}

	public ReqRes getUsersById(UUID id) {
		ReqRes reqRes = new ReqRes();
		try {
			DreamfyreUserPrimaryKey userPK = new DreamfyreUserPrimaryKey(id);
			DreamfyreUser usersById = usersRepo.findById(userPK).orElseThrow(() -> new RuntimeException("User Not found"));
			reqRes.setOurUsers(usersById);
			reqRes.setStatusCode(200);
			reqRes.setMessage("Users with id '" + id + "' found successfully");
		} catch (Exception e) {
			reqRes.setStatusCode(500);
			reqRes.setMessage("Error occurred: " + e.getMessage());
		}
		return reqRes;
	}

	public ReqRes deleteUser(UUID userId) {
		ReqRes reqRes = new ReqRes();
		try {
			DreamfyreUserPrimaryKey userPK = new DreamfyreUserPrimaryKey(userId);
			Optional<DreamfyreUser> userOptional = usersRepo.findById(userPK);
			if (userOptional.isPresent()) {
				usersRepo.deleteById(userPK);
				reqRes.setStatusCode(200);
				reqRes.setMessage("User deleted successfully");
			} else {
				reqRes.setStatusCode(404);
				reqRes.setMessage("User not found for deletion");
			}
		} catch (Exception e) {
			reqRes.setStatusCode(500);
			reqRes.setMessage("Error occurred while deleting user: " + e.getMessage());
		}
		return reqRes;
	}

	public ReqRes updateUser(UUID userId, DreamfyreUser updatedUser) {
		ReqRes reqRes = new ReqRes();
		try {
			DreamfyreUserPrimaryKey userPK = new DreamfyreUserPrimaryKey(userId);
			Optional<DreamfyreUser> userOptional = usersRepo.findById(userPK);
			if (userOptional.isPresent()) {
				DreamfyreUser existingUser = userOptional.get();
				existingUser.setEmail(updatedUser.getEmail());
				existingUser.setRole(updatedUser.getRole());

				// Check if password is present in the request
				if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
					// Encode the password and update it
					existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
				}

				DreamfyreUser savedUser = usersRepo.save(existingUser);
				reqRes.setOurUsers(savedUser);
				reqRes.setStatusCode(200);
				reqRes.setMessage("User updated successfully");
			} else {
				reqRes.setStatusCode(404);
				reqRes.setMessage("User not found for update");
			}
		} catch (Exception e) {
			reqRes.setStatusCode(500);
			reqRes.setMessage("Error occurred while updating user: " + e.getMessage());
		}
		return reqRes;
	}

	public ReqRes getMyInfo(String email) {
		ReqRes reqRes = new ReqRes();
		try {
			Optional<DreamfyreUser> userOptional = usersRepo.findByEmail(email);
			if (userOptional.isPresent()) {
				reqRes.setOurUsers(userOptional.get());
				reqRes.setStatusCode(200);
				reqRes.setMessage("successful");
			} else {
				reqRes.setStatusCode(404);
				reqRes.setMessage("User not found for update");
			}

		} catch (Exception e) {
			reqRes.setStatusCode(500);
			reqRes.setMessage("Error occurred while getting user info: " + e.getMessage());
		}
		return reqRes;

	}
}
