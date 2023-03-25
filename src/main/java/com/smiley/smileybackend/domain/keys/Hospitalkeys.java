package com.smiley.smileybackend.domain.keys;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospitalkeys implements Serializable {
    private long  id;
    private boolean isPartner;
}
