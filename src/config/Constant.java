package config;

public class Constant {
	public static String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVmZjUxNTg0ZDE5YzgzMDAxN2M2YWJlNiIsImRhdGVMb2dpbiI6IjIwMjEtMDEtMDZUMTU6MTc6MTEuNzIxWiIsImlhdCI6MTYwOTk0NjIzMSwiZXhwIjoxNjEwMDMyNjMxfQ.m1gKkuEzG42Wxe6Nt2Tg8EMrSeBmKj1UZJYlqP70Txo";
	public static String API_URL = "https://it4895-nhom5.herokuapp.com/it4788/";
	public static String POST_ID_SOURCE_5 = "5ff5d5da0381ac001792b985";
	public static String POST_ID_SOURCE_4 = "10";
	public static String POST_ID_SOURCE_1 = "216";
	public static String OK = "1000";
	public static String IS_BANNED = "1";
	public static String IS_BLOCKED = "1";
	public static String[] SOURCES = {"http://it4895.herokuapp.com/it4895/", "https://luandz.cf/", "https://bk-it4895.herokuapp.com/", 
			"https://hust-fb-it4895.herokuapp.com/it4788/", "https://it4895-nhom5-v2.herokuapp.com/it4788/", 
			"https://project-facebook-clone.herokuapp.com/it4788/user/"};
	public static String[] APIS_SOURCE_1 = {"", ""};
	public static String[] APIS_SOURCE_2 = {"", ""};
	public static String[] APIS_SOURCE_3 = {"", ""};
	public static String[] APIS_SOURCE_4 = {"comment/get_comment", "post/get_post", "post/edit_post", "get_list_suggested_friends", "get_push_settings"};
	public static String[] APIS_SOURCE_5 = {"comment/get_comment", "post/get_post", "get_list_suggested_friends", "get_push_settings"};
	public static String[] APIS_SOURCE_6 = {"", ""};
//	Thứ tự API get_commoent, get_post, ...
	public static String[] TEST_CASES_GET_COMMENT = {"Unit test 1: The code, message, data strings shall not be NULL as well as non-empty", 
			"Unit test 2: The required fields shall be not NULL as well as non-empty", 
			"Unit test 3: The is_blocked field can't be 1",
			"Unit test 4: The name, id, avatar, online  field can't be NULL or empty"};
	public static String[] TEST_CASES_GET_POST = {"Unit test 1: The code, message, data strings shall not be NULL as well as non-empty", 
			"Unit test 2: The required fields shall be not NULL as well as non-empty", 
			"Unit test 3: The banned field can't be 1", 
			"Unit test 4: The is_blocked field can't be 1", 
			"Unit test 5: The name, id, avatar, online  field can't be NULL or empty"};
	public static String[] TEST_CASES_EDIT_POST = {"Unit test 1: The code, message, data strings shall not be NULL as well as non-empty", 
			"Unit test 2: The post's id from response shall not different from input id",
	};
	public static String[] TEST_CASES_GET_LIST_SUGGESTED_FRIENDS = {"Unit test 1: The code, message, data strings shall not be NULL as well as non-empty", 
			"Unit test 2: The required fields shall be not NULL as well as non-empty",
			"Unit test 3: The user_id in list suggested friends shall not be duplicated",
			"Unit test 4: The user_id in list suggested friends shall not be same with current user",
	};
	public static String[] TEST_CASES_GET_PUSH_SETTINGS = {"Unit test 1: The code, message, data strings shall not be NULL as well as non-empty", 
			"Unit test 2: The required fields shall be not NULL as well as non-empty", 
	};	
}
