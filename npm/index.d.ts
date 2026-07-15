declare module '@apiverve/ipdemographics' {
  export interface ipdemographicsOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface ipdemographicsResponse {
    status: string;
    error: string | null;
    data: IPDemographicsData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface IPDemographicsData {
      ip:           null | string;
      location:     Location;
      demographics: Demographics;
      acsYear:      number | null;
      formatted:    Formatted;
  }
  
  interface Demographics {
      population:            number | null;
      medianAge:             number | null;
      medianHouseholdIncome: number | null;
      perCapitaIncome:       number | null;
      medianHomeValue:       number | null;
      collegeEducatedPct:    number | null;
      unemploymentRate:      number | null;
      homeOwnershipRate:     number | null;
  }
  
  interface Formatted {
      medianHouseholdIncome: null | string;
      perCapitaIncome:       null | string;
      medianHomeValue:       null | string;
  }
  
  interface Location {
      zip:         null | string;
      city:        null | string;
      state:       null | string;
      stateCode:   null | string;
      country:     null | string;
      countryCode: null | string;
      latitude:    number | null;
      longitude:   number | null;
      timezone:    null | string;
  }

  export default class ipdemographicsWrapper {
    constructor(options: ipdemographicsOptions);

    execute(callback: (error: any, data: ipdemographicsResponse | null) => void): Promise<ipdemographicsResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: ipdemographicsResponse | null) => void): Promise<ipdemographicsResponse>;
    execute(query?: Record<string, any>): Promise<ipdemographicsResponse>;
  }
}
