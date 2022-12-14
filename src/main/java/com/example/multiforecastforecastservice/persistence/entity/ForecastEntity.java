package com.example.multiforecastforecastservice.persistence.entity;

import com.example.multiforecastforecastservice.enums.Duration;
import com.example.multiforecastforecastservice.enums.Source;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "forecast")
public class ForecastEntity {

    @Id
    private ObjectId id;

    @Indexed
    private Long userId;
    private Source source;
    private Duration duration;
    private Instant created;
    private DBObject forecast;

    public ForecastEntity(final Long userId, final Source source, final Duration duration,
                          final Instant created, final DBObject forecast) {
        this.userId = userId;
        this.source = source;
        this.duration = duration;
        this.created = created;
        this.forecast = forecast;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(final ObjectId id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(final Source source) {
        this.source = source;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(final Duration duration) {
        this.duration = duration;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(final Instant created) {
        this.created = created;
    }

    public DBObject getForecast() {
        return forecast;
    }

    public void setForecast(final DBObject forecast) {
        this.forecast = forecast;
    }
}
