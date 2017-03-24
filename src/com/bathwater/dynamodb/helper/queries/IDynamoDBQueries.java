package com.bathwater.dynamodb.helper.queries;

import java.util.List;

import com.bathwater.dynamodb.tables.CategoryTableItem;
import com.bathwater.dynamodb.tables.InventoryTableItem;
import com.bathwater.dynamodb.tables.ItemTableItem;
import com.bathwater.dynamodb.tables.MembershipTableItem;
import com.bathwater.dynamodb.tables.ReferralCodeMapper;
import com.bathwater.dynamodb.tables.RequestZipCodeTableItem;
import com.bathwater.dynamodb.tables.ServiceZipCodeTableItem;
import com.bathwater.dynamodb.tables.TimeslotTableItem;
import com.bathwater.dynamodb.tables.TruckTableItem;
import com.bathwater.dynamodb.tables.UserRequestTableItem;

public interface IDynamoDBQueries {

	List<TimeslotTableItem> getTimeSlotByID(String timeslotID);

	List<InventoryTableItem> getStoredItemsByID(String storedItemId);

	List<ServiceZipCodeTableItem> getServiceZipCode(String zipCode);

	ReferralCodeMapper getReferralCodeMapperByID(String referralCode);

	List<RequestZipCodeTableItem> getRequestZipCode(String zipCode);

	List<MembershipTableItem> getMembershipPlanById(String membershipID);

	List<UserRequestTableItem> getUserRequestByID(String userRequestID);

	List<ItemTableItem> getItemByID(String itemID);

	List<CategoryTableItem> getCategoryById(String id);

	List<String> getItemConditionsConfiguration();

	TruckTableItem getTruckByID(String truckID);

}
