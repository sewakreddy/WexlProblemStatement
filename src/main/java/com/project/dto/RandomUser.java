package com.project.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.*;
import java.io.*;
import java.util.List;

public class RandomUser {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://randomuser.me/api/?format=json&gender=female");

        StringBuffer stringBuffer = new StringBuffer();
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String s;
            while ((s = input.readLine()) != null) {
                stringBuffer.append(s);
            }
            System.out.println(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();

        Data data = null;
        try {
            data = mapper.readValue(stringBuffer.toString(), Data.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(data);

        //extract first and last name from data

        try {
            List<Result> newResult = data.getResults();
            Name newName = newResult.get(0).getName();
            String first = newName.getFirst();
            String last = newName.getLast();

            String newFirst = "WeXL" + first;
            String newLast = "WeXL" + last;

            newName.setFirst(newFirst);
            newName.setLast(newLast);
            System.out.println(data);
        }
        catch(NullPointerException e)
        {
            System.out.print("NullPointerException Caught");
        }
    }
}