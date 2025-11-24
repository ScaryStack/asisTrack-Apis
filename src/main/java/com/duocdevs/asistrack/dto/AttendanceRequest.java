package com.duocdevs.asistrack.dto;

import lombok.Data;

@Data
public class AttendanceRequest {

    private String typeAttendance;
    private String date;
    private String hour;
    private String location;
    private String latitude;
    private String longitude;
    private Integer userId;
}
