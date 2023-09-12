package com.example.demo.models.SteamModel;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Species {
    public String average_height;
    public String average_lifespan;
    public String classification;
    public Date created;
    public String designation;
    public Date edited;
    public String eye_colors;
    public String hair_colors;
    public String homeworld;
    public String language;
    public String name;
    public ArrayList<String> people;
    public ArrayList<String> films;
    public String skin_colors;
    public String url;
}
