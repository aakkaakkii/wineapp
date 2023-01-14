package com.wine.userservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WinePriceUpdatedResponse {
    private String wineId;
    private String wineName;
    private Float newWinePrice;
}
