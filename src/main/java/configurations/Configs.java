package configurations;

public interface Configs {
	
	String ENV = "GE2";

	String DIT_BaseUri = "https://delldevelop.vslabs.cloud";
	String GE2_BaseUri = "https://ccp-g2.us.dell.com";
	String GE4_BaseUri = "https://dtc-development4.vslabs.cloud";
	String STG_BaseUri = "https://stagcl01-s3b.vslabs.cloud";


	                                   //South-Customer

	//Sales Representative
	String getSalesRepV1 = "/south-customers/api/v1/salesrep/{email}";
	String updateSalesRepV1 = "/south-customers/api/v1/salesrep/{email}";
	String deleteSalesRepV1 = "/south-customers/api/v1/salesrep/{email}";
	String createSalesRepV1 = "/south-customers/api/v1/salesrep";
	String getAllSalesRepV1 = "/south-customers/api/v1/salesrep";//No UserStory
	
	//Customers
	String createCustomerV1 = "/south-customers/api/v1/customer";
	String createCustomerV2 = "/south-customers/api/v2/customer";
	String getCustomerV1 = "/south-customers/api/v1/customer/{dcn}";
	String getCustomerV2 = "/south-customers/api/v2/customer/{dcn}/businessunit/{buId}";
	String getCustomerPaymentMethodsV1 = "/south-customers/api/v1/customer/{dcn}/paymentmethods";
	String getCustomerPaymentMethodsV2 = "/south-customers/api/v2/paymentmethods";
	String getCustomerBillingCadenceV1 = "/south-customers/api/v1/customer/{dcn}/billingcadence";
	String getCustomerBillingCadenceV2 ="/south-customers/api/v2/billingcadence";
	String getCustomerPrimarySalesRepV1 = "/south-customers/api/v1/customer/{dcn}/salesrep";
	String getCustomerPrimarySalesRepV2 = "/south-customers/api/v2/salesrep";
	String getCustomerPurchaseEntityV1 = "/south-customers/api/v1/purchaseEntity/{dcn}";
	String getCustomerPurchaseEntityV2 = "/south-customers/api/v2/purchaseEntity";
	String getCustomersUnderSalesRepV1 = "/south-customers/api/v1/customers/salesrep/{email}";
	String getCustomersUnderSalesRepV2 = "/south-customers/api/v2/customers/salesrep/{email}";
	String getAllCustomersV1 = "/south-customers/api/v1/customer";//No UserStory
	String getAllCustomersV2 = "/south-customers/api/v2/customers";//No UserStory
	String updateCustomerV1 = "/south-customers/api/v1/customer/{dcn}";
	String updateCustomerV2 = "/south-customers/api/v2/customer/{dcn}/businessunit/{buId}";
	String updateCustomerDiscountV1 = "/south-customers/api/v1/customer/{dcn}/discount/{discount}";
	String updateCustomerDiscountV2 = "/south-customers/api/v2/discount/{discount}";
	String deleteCustomerV1 = "/south-customers/api/v1/customer/{dcn}";
	String deleteCustomerV2 = "/south-customers/api/v2/customer/{dcn}/businessunit/{buId}";

	//Sites
	String createSiteV1 = "/south-customers/api/v1/customer/{dcn}/site";
	String createSiteV2 = "/south-customers/api/v2/site";
	String getSiteBySiteIDV1 = "/south-customers/api/v1/customer/{dcn}/site/{siteId}";
	String getSiteBySiteIDV2 = "/south-customers/api/v2/site/{siteId}";
	String getPrimarySiteV1 = "/south-customers/api/v1/purchaseEntity/{dcn}/primarysite";
	String getPrimarySiteV2 = "/south-customers/api/v2/purchaseEntity/primarysite";
	String getAllSitesV1 = "/south-customers/api/v1/sites/customer/{dcn}";
	String getAllSitesV2 = "/south-customers/api/v2/sites";
	String updateSiteContactV1 = "/south-customers/api/v1/updatecontact/customer/{dcn}/businessunit/{buid}";
	String updateSiteContactV2 = "/south-customers/api/v2/updatecontact";
	String initiateUCIDV1= "/south-customers/api/v1/initiateucid/customer/{dcn}/businessunit/{buid}/site/{siteId}";
	String initiateUCIDV2= "/south-customers/api/v2/initiateucid/site/{siteId}";
	String getUCIDStatusV1 = "/south-customers/api/v1/ucidstatus/customer/{dcn}/businessunit/{buid}/site/{siteId}";
	String getUCIDStatusV2 = "/south-customers/api/v2/ucidstatus/site/{siteId}";
	String searchSiteAddress= "/south-customers/api/v1/customers/search";
	String searchSiteAddressV2= "/south-customers/api/v2/customers/search";
	String getContactInfoV1= "/south-customers/api/v1/customer/{dcn}/contact/{camLocationId}/businessUnitId/{businessUnitId}";
	String getContactInfoV2= "/south-customers/api/v2/contact/{camLocationId}";
	String getprimaryBillingAddress = "/south-customers/api/v2/purchaseEntity/primaryBilling";
	String getprimaryShippingAddress = "/south-customers/api/v2/purchaseEntity/primaryShipping";
	
	    							// South-Notifications
	
	//UserOptinOptout
	String createUserOptinOptoutV1 = "/south-notifications/api/v1/userpreferences";
	String createUserOptinOptoutV2 = "/south-notifications/api/v2/userpreferences";
	String getUserOptinOptoutV1 = "/south-notifications/api/v1/userpreferences/customer/{dcn}/user/{email}";
	String getUserOptinOptoutV2 = "/south-notifications/api/v2/userpreferences/customer/user/{email}";
	String updateUserOptinOptoutV1 = "/south-notifications/api/v1/userpreferences/customer/{dcn}/user/{email}";
	String updateUserOptinOptoutV2 = "/south-notifications/api/v2/userpreferences/customer/user/{email}";
	String deleteUserOptinOptoutV1 = "/south-notifications/api/v1/userpreferences/customer/{dcn}/user/{email}";
	String deleteUserOptinOptoutV2 = "/south-notifications/api/v2/userpreferences/customer/user/{email}";
	String bulkUpdateUserOptinOptoutV1 = "/south-notifications/api/v1/userpreferences/bulkupdate";//No UserStory
	
	//Notifications
	String createNotificationV1 = "/south-notifications/api/v1/notification";
	String createNotificationV2 = "/south-notifications/api/v2/notification";
	String getNotificationV1 = "/south-notifications/api/v1/notification/customer/{dcn}/user/{email}";
	String getNotificationV2 = "/south-notifications/api/v2/notification/customer/user/{email}";
	String updateNotificationV1 = "/south-notifications/api/v1/notification";
	String deleteNotificationV1 = "/south-notifications/api/v1/notification";
	String deleteNotificationV2 = "/south-notifications/api/v2/notification";
	
	//Preferences
	String createPreferencesV1 = "/south-notifications/api/v1/preference/";
	String getAllPreferencesV1 = "/south-notifications/api/v1/preferences";
	String getPayloadStructureV1 = "/south-notifications/api/v1/payloadstructure/event/{eventName}";
	String updatePreferencesV1 = "/south-notifications/api/v1/preference/{preferenceId}";
	String deletePreferencesV1 = "/south-notifications/api/v1/preference/{preferenceId}/right/{rightId}";

}
