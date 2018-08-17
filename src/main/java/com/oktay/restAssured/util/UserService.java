package com.oktay.restAssured.util;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;


public class UserService {

    private final RestAssured request;

    public UserService() {
        request = WebServiceManager.getInstance().getRestRequest();
    }

    //Tanımlı olan kullanıcının blokesini kaldırmak için kullanılır
    public void unBlockUser(String userName) {

        try {

            JSONObject requestParams = new JSONObject();
            requestParams.put("username", userName);

            request.requestSpecification.body(requestParams.toJSONString());
            Response response = request.post("/Values/UpdateUser");

            Assert.assertEquals(response.getStatusCode(), 200);
            System.err.println(response.body().asString());
            Assert.assertTrue("Kullanıcı blokesi kaldırıldı!", response.body().asString().contains("Success"));

        } catch (Exception ex) {
            Assert.fail("Unblocking user service timeout exception!");
        }

    }
}
