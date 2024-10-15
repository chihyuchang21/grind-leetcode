import java.util.*;

public class Result {

    public static List<String> implementAPI(List<String> logs) {
        // 記錄已註冊的用戶及其密碼
        Map<String, String> registeredUsers = new HashMap<>();
        // 記錄已經登入的用戶
        Set<String> loggedInUsers = new HashSet<>();
        // 儲存回應的結果
        List<String> result = new ArrayList<>();

        // 遍歷每一個 API 請求
        for (String log : logs) {
            // 拆分請求，提取 API 名稱與參數
            String[] parts = log.split(" ");
            String command = parts[0];
            String username = parts[1];

            // 根據不同的 API 操作來處理
            switch (command) {
                case "register":
                    String password = parts[2];
                    if (registeredUsers.containsKey(username)) {
                        result.add("Username already exists");
                    } else {
                        registeredUsers.put(username, password);
                        result.add("Registered Successfully");
                    }
                    break;

                case "login":
                    password = parts[2];
                    if (!registeredUsers.containsKey(username) ||
                            !registeredUsers.get(username).equals(password) ||
                            loggedInUsers.contains(username)) {
                        result.add("Login Unsuccessful");
                    } else {
                        loggedInUsers.add(username);
                        result.add("Logged In Successfully");
                    }
                    break;

                case "logout":
                    if (loggedInUsers.contains(username)) {
                        loggedInUsers.remove(username);
                        result.add("Logged Out Successfully");
                    } else {
                        result.add("Logout Unsuccessful");
                    }
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // 測試數據
        List<String> logs = Arrays.asList(
                "register alice 12345",
                "login alice 12345",
                "logout alice",
                "login alice 54321",
                "register bob 12345",
                "login bob 12345",
                "logout bob"
        );

        // 調用方法並打印結果
        List<String> result = implementAPI(logs);
        for (String res : result) {
            System.out.println(res);
        }
    }
}
