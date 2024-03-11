package com.nt.hash;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@RedisHash("Customer")
public class Customer implements Serializable {

    private static final long serialversionUID = 1L;

    private Integer cid;
    private String firstName;
    private String lastName;
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dob;
    private String json;



}
