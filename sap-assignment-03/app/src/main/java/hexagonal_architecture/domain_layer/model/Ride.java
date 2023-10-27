package hexagonal_architecture.domain_layer.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Indexed;

import java.util.Date;
import java.util.Optional;

@Document(collection = "ride")
public class Ride {

    @Id
    private String id;
    @NotBlank
    private String userId;
    @NotBlank
    private String escooterId;
    @NotEmpty
    private Date startedDate;
    private Date endDate;
    private boolean ongoing;

    public Ride() {
        this.startedDate = new Date();
        this.ongoing = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEscooterId() {
        return escooterId;
    }

    public void setEscooterId(String escooterId) {
        this.escooterId = escooterId;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public Optional<Date> getEndDate() {
        return Optional.ofNullable(this.endDate);
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isOngoing() {
        return ongoing;
    }

    public void setOngoing(boolean ongoing) {
        this.ongoing = ongoing;
    }
}
