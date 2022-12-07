package com.cs411.solar_project.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class SearchService {

    public String preURL = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=solar companies near";
    public String infoPreURL = "https://maps.googleapis.com/maps/api/place/details/json?place_id=";
    public String preURLToGetLocation = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=";
    public String key = "&key=AIzaSyBawHfdRBf3Z3zTCMd2oRxQJgQ24Li1kUE";

    public List<List<String>> getCompanyInfo(String address) throws IOException, JSONException {
        List<List<String>> res = new ArrayList<>();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        String addressURL = preURL + address + key;

        Request request = new Request.Builder()
                .url(addressURL)
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        String body = response.body().string();
        JSONObject jsonobject = new JSONObject(body);

        for(int i = 0; i <= 9; i ++) {
            JSONObject name = jsonobject.getJSONArray("results").getJSONObject(i);
            String place_id = name.getString("place_id");
            String placeAPI = infoPreURL + place_id + key;

            Request request_Info = new Request.Builder()
                    .url(placeAPI)
                    .method("GET", null)
                    .build();
            Response response_Info = client.newCall(request_Info).execute();
            String body_Info = response_Info.body().string();
            JSONObject jsonobject_Info = new JSONObject(body_Info);

            JSONObject company = jsonobject_Info.getJSONObject("result");
            List<String> company_Info = new ArrayList<>();
            company_Info.add(company.getString("name"));
            company_Info.add(company.getString("formatted_address"));
            boolean has_website = company.has("website") ? company_Info.add(company.getString("website")):company_Info.add("no website on file");
            boolean has_rating = company.has("rating") ? company_Info.add(company.getString("rating")):company_Info.add("no rating on file");
            boolean has_phone_number = company.has("international_phone_number") ? company_Info.add(company.getString("international_phone_number")):company_Info.add("no phone number on file");
            res.add(company_Info);
        }
        return res;
    }

    public List<Double> getLatNLng (String address) throws IOException, JSONException {
        List<Double> latNLng = new ArrayList<>();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        String addressURL = preURLToGetLocation + address + key;

        Request request = new Request.Builder()
                .url(addressURL)
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        String body = response.body().string();
        JSONObject jsonobject = new JSONObject(body);

        JSONObject location = jsonobject.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location");
        double lat = location.getDouble("lat");
        double lng = location.getDouble("lng");
        latNLng.add(lat);
        latNLng.add(lng);
        return latNLng;
    }

    public double getSavingAmount (double bill) throws IOException, JSONException {
        return bill*0.75*12*25;
    }
}