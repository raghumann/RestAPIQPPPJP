public class InputPayload {

    public static String getAddBookPayload(){
        return "{" +
                "    \"name\": \"%s\"," +
                "    \"isbn\": \"%s\"," +
                "    \"aisle\": \"%s\"," +
                "    \"author\": \"%s\"" +
                "}";
    }

    public static String getUpdateEmployeePayload(){
        return "{" +
                "        \"name\": \"Nutan Tiwari\"," +
                "            \"salary\": \"30000\"," +
                "            \"age\": \"24\"" +
                "    }";
    }


}
