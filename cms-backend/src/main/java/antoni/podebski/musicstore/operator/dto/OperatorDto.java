package antoni.podebski.musicstore.operator.dto;

import static antoni.podebski.musicstore.common.date.Dates.DATE_FORMAT_LONG;
import static antoni.podebski.musicstore.common.date.Dates.DATE_FORMAT_SHORT;

import antoni.podebski.musicstore.common.deserializer.OffsetDateTimeDeserializer;
import antoni.podebski.musicstore.common.error.ErrorCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.OffsetDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperatorDto {

    private Long id;

    @NotBlank(message = ErrorCode.NOT_BLANK)
    private String name;

    @NotBlank(message = ErrorCode.NOT_BLANK)
    private String surname;

    @Email
    @NotBlank(message = ErrorCode.NOT_BLANK)
    private String email;

    @NotBlank(message = ErrorCode.NOT_BLANK)
    private String password;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT_LONG)
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime lastLoggedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public OffsetDateTime getLastLoggedAt() {
        return lastLoggedAt;
    }

    public void setLastLoggedAt(OffsetDateTime lastLoggedAt) {
        this.lastLoggedAt = lastLoggedAt;
    }

}
