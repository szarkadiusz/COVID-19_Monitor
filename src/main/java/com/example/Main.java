package com.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main extends JFrame {
    private static JFrame jFrame;
    private static JPanel jPanel;
    private static JLabel infectedTotal;
    private static JLabel infectedTotalNew;
    private static JLabel active;
    private static JLabel activeNew;
    private static JLabel deaths;
    private static JLabel deathsNew;
    private static JLabel cured;
    private static JLabel curedNew;
    private static JLabel updateDate;
    private static JLabel country;


    public static void main(String[] args) throws IOException {

        jFrame = new JFrame("COVID-19 MONITOR");

        jPanel = new JPanel(new GridLayout(5, 2));
        jPanel.setBackground(Color.darkGray);
        jPanel.setSize(800, 800);

        countryCreate();
        updateDateCreate();
        infectedTotalCreate();
        activeCreate();
        infectedTotalNewCreate();
        activeNewCreate();
        deathsCreate();
        curedCreate();
        deathsNewCreate();
        curedNewCreate();


        createHttpResponse();

        jPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        jFrame.setVisible(true);
        jFrame.setSize(800, 800);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.add(jPanel);
        jFrame.pack();
    }


    private static void countryCreate() throws IOException {

        String getCountry = createHttpResponse().getString("country");
        country = new JLabel("Country: " + getCountry);
        jPanel.add(country);
        country.setForeground(Color.white);
        setHeightOfFont_LOW(country);


    }

    private static void updateDateCreate() throws IOException {
        String getUpdateDate = createHttpResponse().getString("time");
        StringBuilder sb = new StringBuilder();
        sb.append(getUpdateDate.substring(0, 10));
        sb.append(" ").append(getUpdateDate.substring(11, 19));
        sb.toString();
        updateDate = new JLabel("Updated: " + sb);
        jPanel.add(updateDate);
        updateDate.setForeground(Color.white);
        setHeightOfFont_LOW(updateDate);

    }

    private static void infectedTotalCreate() throws IOException {
        JSONObject getCases = createHttpResponse().getJSONObject("cases");
        String getTotal = String.valueOf(getCases.getInt("total"));
        infectedTotal = new JLabel("Infected: " + getTotal);
        jPanel.add(infectedTotal);
        infectedTotal.setForeground(Color.yellow);
        setHeightOfFont_HIGH(infectedTotal);


    }

    private static void activeCreate() throws IOException {
        JSONObject getCases = createHttpResponse().getJSONObject("cases");
        String getActive = String.valueOf(getCases.getInt("active"));
        active = new JLabel("Active: " + getActive);
        jPanel.add(active);
        active.setForeground(Color.orange);
        setHeightOfFont_HIGH(active);

    }

    private static void infectedTotalNewCreate() throws IOException {
        JSONObject getCases = createHttpResponse().getJSONObject("cases");
        String getNew = String.valueOf(getCases.getString("new"));

        infectedTotalNew = new JLabel("Todays new infected " + getNew);
        jPanel.add(infectedTotalNew);
        infectedTotalNew.setForeground(Color.yellow);
        setHeightOfFont_LOW(infectedTotalNew);


    }

    private static void activeNewCreate() throws IOException {
        JSONObject getCases = createHttpResponse().getJSONObject("cases");
        String getNew = String.valueOf(getCases.getString("new"));

        activeNew = new JLabel("Todays new active " + getNew);
        jPanel.add(activeNew);
        activeNew.setForeground(Color.orange);
        setHeightOfFont_LOW(activeNew);


    }

    private static void deathsCreate() throws IOException {
        JSONObject getCases = createHttpResponse().getJSONObject("deaths");
        String getDeaths = String.valueOf(getCases.getInt("total"));

        deaths = new JLabel("Deaths: " + getDeaths);
        jPanel.add(deaths);
        deaths.setForeground(Color.red);
        setHeightOfFont_HIGH(deaths);


    }

    private static void curedCreate() throws IOException {
        JSONObject getCases = createHttpResponse().getJSONObject("cases");
        String getRecovered = String.valueOf(getCases.getInt("recovered"));
        cured = new JLabel("Cured: " + getRecovered);
        jPanel.add(cured);
        cured.setForeground(Color.green);
        setHeightOfFont_HIGH(cured);

    }

    private static void deathsNewCreate() throws IOException {
        JSONObject getCases = createHttpResponse().getJSONObject("deaths");
        String getDeathsNew = String.valueOf(getCases.getString("new"));

        deathsNew = new JLabel("Todays new deaths " + getDeathsNew);
        jPanel.add(deathsNew);
        deathsNew.setForeground(Color.red);
        setHeightOfFont_LOW(deathsNew);


    }

    private static void curedNewCreate() {

        curedNew = new JLabel("Todays new cured No info");
        jPanel.add(curedNew);
        curedNew.setForeground(Color.green);
        setHeightOfFont_LOW(curedNew);


    }

    private static void setHeightOfFont_HIGH(JLabel jLabel) {
        jLabel.setFont(new Font("Helvetica", Font.BOLD, 50));
    }

    private static void setHeightOfFont_LOW(JLabel jLabel) {
        jLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
    }

    public static OkHttpClient createHttpClient() {

        return new OkHttpClient();
    }

    public static Request createHttpRequest() {
        return new Request.Builder()
                .url("https://covid-193.p.rapidapi.com/statistics?country=Poland")
                .get()
                .addHeader("x-rapidapi-host", "covid-193.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "763f47715fmsh5e3be17d0369764p17cd41jsn0c89dde4e190")
                .build();


    }

    private static JSONObject createHttpResponse() throws IOException {

        OkHttpClient client = createHttpClient();
        Request request = createHttpRequest();
        Response response = client.newCall(request).execute();

        JSONObject getParams = new JSONObject(response.body().string());

        JSONArray responseArray = getParams.getJSONArray("response");

        JSONObject getParamsofObject0 = responseArray.getJSONObject(0);

        return getParamsofObject0;

    }
}