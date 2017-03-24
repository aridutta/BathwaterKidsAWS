package com.bathwater.dynamodb.helper.queries;

import java.text.ParseException;
import java.util.List;

import com.bathwater.dynamodb.tables.CategoryTableItem;
import com.bathwater.dynamodb.tables.DriverTableItem;
import com.bathwater.dynamodb.tables.DriverTruckHistoryTableItem;
import com.bathwater.dynamodb.tables.InventoryTableItem;
import com.bathwater.dynamodb.tables.ItemTableItem;
import com.bathwater.dynamodb.tables.MembershipTableItem;
import com.bathwater.dynamodb.tables.OAuthTableItem;
import com.bathwater.dynamodb.tables.ServiceZipCodeTableItem;
import com.bathwater.dynamodb.tables.TimeslotTableItem;
import com.bathwater.dynamodb.tables.TruckTableItem;
import com.bathwater.dynamodb.tables.UserRequestTableItem;
import com.bathwater.dynamodb.tables.UserTableItem;

public interface IDynamoDBScans {

	List<TimeslotTableItem> getAvailableTimeslots() throws ParseException;

	List<OAuthTableItem> isAdminExists(String email);

	List<OAuthTableItem> getAdmins(String role);

	List<OAuthTableItem> getAdmins();

	List<UserTableItem> getUsersBasedOnReferralCode(String string);

	List<UserTableItem> getUsersBasedOnEmail(String emailAddress);

	List<MembershipTableItem> getAllPlans();

	List<UserTableItem> getUsersBasedById(String userId);

	List<TimeslotTableItem> getAllTimeslots();

	List<TimeslotTableItem> getTimeslotsByDate(String date);

	int getBookedCountForTimeslot(String date, String timeslot);

	List<InventoryTableItem> getBathwaterItems();

	List<InventoryTableItem> getItemByUserID(String userID);

	List<UserRequestTableItem> getAllUserRequests(String status);

	List<UserTableItem> getAllUsers();

	List<CategoryTableItem> getCategories(String parentID);

	List<ItemTableItem> getItemsByCategory(String categoryID);

	List<ItemTableItem> getAllItems();

	List<InventoryTableItem> getBathwaterItems(String filterID);

	List<InventoryTableItem> getSharingItems();

	List<TimeslotTableItem> getTimeslotsByTimeAndDate(String date, String time);

	List<ServiceZipCodeTableItem> getAllZipCodes();

	List<ServiceZipCodeTableItem> getZipCodeByZipCode(String zipCode);

	List<DriverTableItem> getDriverById(String driverID);

	List<DriverTableItem> getAllDrivers();

	List<TruckTableItem> getAllTrucks();

	List<TruckTableItem> getTruckById(String truckID);

	List<DriverTruckHistoryTableItem> getTodaysDriverTruckHistoryByDriverIDAndTruckID(String driverID,
			String existingTruckId);

	List<UserRequestTableItem> getUserRequestsById(String userRequestID);

	List<DriverTruckHistoryTableItem> getDriverTruckHistory();

	List<DriverTableItem> getDriverByEmail(String email);

	List<DriverTableItem> getDriverByLicenseID(String email);

	List<UserRequestTableItem> getTodaysUserRequestsByDriverID(String driverID);

	List<InventoryTableItem> getItemByItemCode(String string);

	List<UserRequestTableItem> getTodaysCheckIns();

	List<UserRequestTableItem> getTodaysPickups();

}
