//package com.example.securi;
//
//import com.android.volley.AuthFailureError;
//import com.android.volley.Response;
//import com.android.volley.toolbox.StringRequest;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class LoginRequest extends StringRequest {
//    //서버 url 설정(php파일 연동)
//    final static  private String URL="http://securi.dothome.co.kr/securilogin.php";
//    private Map<String,String>map;
//
//    public LoginRequest(String userid, String userpw, Response.Listener<String>listener){
//        super(Method.POST,URL,listener,null);
//
//        map=new HashMap<>();
//        map.put("userid",userid);
//        map.put("userpw",userpw);
//
//    }
//
//    @Override
//    protected Map<String, String> getParams() throws AuthFailureError {
//        return map;
//    }
//}
