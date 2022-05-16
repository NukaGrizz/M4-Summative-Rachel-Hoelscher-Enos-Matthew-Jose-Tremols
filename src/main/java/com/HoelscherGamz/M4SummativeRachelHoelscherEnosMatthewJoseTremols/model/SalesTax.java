package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "sales_tax_rate")
public class SalesTax {

    @NotNull
    @Column(columnDefinition = "CHAR(2)")
    private String state;

    @NotNull
    @Digits(integer = 3,fraction = 2)
    private BigDecimal rate;

    @Index(name = "ix_state_rate", columnList = "state", unique = true)


/*

create unique index ix_state_rate on sales_tax_rate (state);

Alabama—AL: .05

Alaska—AK: .06

Arizona—AZ: .04

Arkansas—AR: .06

California—CA: .06

Colorado—CO: .04

Connecticut—CT: .03

Delaware—DE: .05

Florida—FL: .06

Georgia—GA: .07

Hawaii—HI: .05

Idaho—ID: .03

Illinois—IL: .05

Indiana—IN: .05

Iowa—IA: .04

Kansas—KS: .06

Kentucky—KY: .04

Louisiana—LA: .05

Maine—ME: .03

Maryland—MD: .07

Massachusetts—MA: .05

Michigan—MI: .06

Minnesota—MN: .06

Mississippi—MS: .05

Missouri—MO: .05

Montana—MT: .03

Nebraska—NE: .04

Nevada—NV: .04

New Hampshire—NH: .06

New Jersey—NJ: .05

New Mexico—NM: .05

New York—NY: .06

North Carolina—NC: .05

North Dakota—ND: .05

Ohio—OH: .04

Oklahoma—OK: .04

Oregon—OR: .07

Pennsylvania—PA: .06

Rhode Island—RI: .06

South Carolina—SC: .06

South Dakota—SD: .06

Tennessee—TN: .05

Texas—TX: .03

Utah—UT: .04

Vermont—VT: .07

Virginia—VA: .06

Washington—WA: .05

West Virginia—WV: .05

Wisconsin—WI: .03

Wyoming—WY: .04
 */

}
