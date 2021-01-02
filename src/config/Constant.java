package config;

public class Constant {
	public static String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVmY2FkYzQ5ZWI2ZGFiMjA5NGViZjA2NyIsImRhdGVMb2dpbiI6IjIwMjEtMDEtMDJUMTI6MzA6MTAuMzYwWiIsImlhdCI6MTYwOTU5MDYxMCwiZXhwIjoxNjA5Njc3MDEwfQ.iVJBYUvKl838hwH5XcaLhqV27Yy60642SA7DX7nzXkM";
	public static String API_URL = "https://it4895-nhom5.herokuapp.com/it4788/";
	public static String POST_ID = "5fcdf1880054254eac0e253e";
	public static String OK = "1000";
	public static String IS_BANNED = "1";
	public static String IS_BLOCKED = "1";
	public static String[] SOURCES = {"http://it4895.herokuapp.com/", "https://luandz.cf/", "https://bk-it4895.herokuapp.com/", 
			"https://hust-fb-it4895.herokuapp.com/", "https://it4895-nhom5.herokuapp.com/", 
			"https://project-facebook-clone.herokuapp.com/it4788/user/"};
	public static String[] APIS_SOURCE_1 = {"", ""};
	public static String[] APIS_SOURCE_2 = {"", ""};
	public static String[] APIS_SOURCE_3 = {"", ""};
	public static String[] APIS_SOURCE_4 = {"", ""};
	public static String[] APIS_SOURCE_5 = {"comment/get_comment", "post/get_post"};
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
}
