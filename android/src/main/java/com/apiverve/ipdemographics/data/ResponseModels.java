// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     IPDemographicsData data = Converter.fromJsonString(jsonString);

package com.apiverve.ipdemographics.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static IPDemographicsData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(IPDemographicsData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(IPDemographicsData.class);
        writer = mapper.writerFor(IPDemographicsData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// IPDemographicsData.java

package com.apiverve.ipdemographics.data;

import com.fasterxml.jackson.annotation.*;

public class IPDemographicsData {
    private String ip;
    private Location location;
    private Demographics demographics;
    private long acsYear;

    @JsonProperty("ip")
    public String getIP() { return ip; }
    @JsonProperty("ip")
    public void setIP(String value) { this.ip = value; }

    @JsonProperty("location")
    public Location getLocation() { return location; }
    @JsonProperty("location")
    public void setLocation(Location value) { this.location = value; }

    @JsonProperty("demographics")
    public Demographics getDemographics() { return demographics; }
    @JsonProperty("demographics")
    public void setDemographics(Demographics value) { this.demographics = value; }

    @JsonProperty("acsYear")
    public long getAcsYear() { return acsYear; }
    @JsonProperty("acsYear")
    public void setAcsYear(long value) { this.acsYear = value; }
}

// Demographics.java

package com.apiverve.ipdemographics.data;

import com.fasterxml.jackson.annotation.*;

public class Demographics {
    private long population;
    private double medianAge;
    private long medianHouseholdIncome;
    private long perCapitaIncome;
    private long medianHomeValue;
    private double collegeEducatedPct;
    private double unemploymentRate;
    private double homeOwnershipRate;

    @JsonProperty("population")
    public long getPopulation() { return population; }
    @JsonProperty("population")
    public void setPopulation(long value) { this.population = value; }

    @JsonProperty("medianAge")
    public double getMedianAge() { return medianAge; }
    @JsonProperty("medianAge")
    public void setMedianAge(double value) { this.medianAge = value; }

    @JsonProperty("medianHouseholdIncome")
    public long getMedianHouseholdIncome() { return medianHouseholdIncome; }
    @JsonProperty("medianHouseholdIncome")
    public void setMedianHouseholdIncome(long value) { this.medianHouseholdIncome = value; }

    @JsonProperty("perCapitaIncome")
    public long getPerCapitaIncome() { return perCapitaIncome; }
    @JsonProperty("perCapitaIncome")
    public void setPerCapitaIncome(long value) { this.perCapitaIncome = value; }

    @JsonProperty("medianHomeValue")
    public long getMedianHomeValue() { return medianHomeValue; }
    @JsonProperty("medianHomeValue")
    public void setMedianHomeValue(long value) { this.medianHomeValue = value; }

    @JsonProperty("collegeEducatedPct")
    public double getCollegeEducatedPct() { return collegeEducatedPct; }
    @JsonProperty("collegeEducatedPct")
    public void setCollegeEducatedPct(double value) { this.collegeEducatedPct = value; }

    @JsonProperty("unemploymentRate")
    public double getUnemploymentRate() { return unemploymentRate; }
    @JsonProperty("unemploymentRate")
    public void setUnemploymentRate(double value) { this.unemploymentRate = value; }

    @JsonProperty("homeOwnershipRate")
    public double getHomeOwnershipRate() { return homeOwnershipRate; }
    @JsonProperty("homeOwnershipRate")
    public void setHomeOwnershipRate(double value) { this.homeOwnershipRate = value; }
}

// Location.java

package com.apiverve.ipdemographics.data;

import com.fasterxml.jackson.annotation.*;

public class Location {
    private String zip;
    private String city;
    private String state;
    private String stateCode;
    private String country;
    private String countryCode;
    private double latitude;
    private double longitude;
    private String timezone;

    @JsonProperty("zip")
    public String getZip() { return zip; }
    @JsonProperty("zip")
    public void setZip(String value) { this.zip = value; }

    @JsonProperty("city")
    public String getCity() { return city; }
    @JsonProperty("city")
    public void setCity(String value) { this.city = value; }

    @JsonProperty("state")
    public String getState() { return state; }
    @JsonProperty("state")
    public void setState(String value) { this.state = value; }

    @JsonProperty("stateCode")
    public String getStateCode() { return stateCode; }
    @JsonProperty("stateCode")
    public void setStateCode(String value) { this.stateCode = value; }

    @JsonProperty("country")
    public String getCountry() { return country; }
    @JsonProperty("country")
    public void setCountry(String value) { this.country = value; }

    @JsonProperty("countryCode")
    public String getCountryCode() { return countryCode; }
    @JsonProperty("countryCode")
    public void setCountryCode(String value) { this.countryCode = value; }

    @JsonProperty("latitude")
    public double getLatitude() { return latitude; }
    @JsonProperty("latitude")
    public void setLatitude(double value) { this.latitude = value; }

    @JsonProperty("longitude")
    public double getLongitude() { return longitude; }
    @JsonProperty("longitude")
    public void setLongitude(double value) { this.longitude = value; }

    @JsonProperty("timezone")
    public String getTimezone() { return timezone; }
    @JsonProperty("timezone")
    public void setTimezone(String value) { this.timezone = value; }
}