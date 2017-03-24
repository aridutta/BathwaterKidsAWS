package com.bathwater;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.bathwater.dto.MembershipMock;
import com.bathwater.dynamodb.helper.IDynamoDBHelper;
import com.bathwater.dynamodb.helper.queries.IDynamoDBScans;
import com.bathwater.dynamodb.tables.BathwaterItem;
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
import com.bathwater.dynamodb.tables.UserTableItem.Membership;

public class MockDBHelper implements IDynamoDBScans, IDynamoDBHelper {

	@Override
	public List<UserTableItem> getUsersBasedOnEmail(String name) {

		UserTableItem table = new UserTableItem();
		Membership mem = new Membership();
		List<UserTableItem> list = null;
		if(name.equals(Constants.email)){
			table.setEmailAddress(Constants.email);
			table.setPassword(Constants.password);
			table.setUserType(Constants.userType);
			table.setToken(Constants.token);
			table.setPhoneNumber(Constants.phone);
			table.setActive(Constants.active);
			table.setUserID(Constants.userId);
			mem.setDescription(Constants.cardNum);
			table.setMembership(mem);
			list = new ArrayList<>();
			list.add(table);
		}

		return list;
	}
	
	@Override
	public boolean putItem(BathwaterItem item) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteItem(BathwaterItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DynamoDBMapper getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DynamoDB getDynamoDB() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<TimeslotTableItem> getAvailableTimeslots() throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<OAuthTableItem> isAdminExists(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OAuthTableItem> getAdmins(String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OAuthTableItem> getAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserTableItem> getUsersBasedOnReferralCode(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MembershipTableItem> getAllPlans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserTableItem> getUsersBasedById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeslotTableItem> getAllTimeslots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeslotTableItem> getTimeslotsByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBookedCountForTimeslot(String date, String timeslot) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<InventoryTableItem> getBathwaterItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InventoryTableItem> getItemByUserID(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRequestTableItem> getAllUserRequests(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserTableItem> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryTableItem> getCategories(String parentID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemTableItem> getItemsByCategory(String categoryID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemTableItem> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InventoryTableItem> getBathwaterItems(String filterID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InventoryTableItem> getSharingItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeslotTableItem> getTimeslotsByTimeAndDate(String date, String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServiceZipCodeTableItem> getAllZipCodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServiceZipCodeTableItem> getZipCodeByZipCode(String zipCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DriverTableItem> getDriverById(String driverID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DriverTableItem> getAllDrivers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TruckTableItem> getAllTrucks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TruckTableItem> getTruckById(String truckID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DriverTruckHistoryTableItem> getTodaysDriverTruckHistoryByDriverIDAndTruckID(String driverID,
			String existingTruckId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRequestTableItem> getUserRequestsById(String userRequestID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DriverTruckHistoryTableItem> getDriverTruckHistory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DriverTableItem> getDriverByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DriverTableItem> getDriverByLicenseID(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRequestTableItem> getTodaysUserRequestsByDriverID(String driverID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InventoryTableItem> getItemByItemCode(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRequestTableItem> getTodaysCheckIns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRequestTableItem> getTodaysPickups() {
		// TODO Auto-generated method stub
		return null;
	}

}
