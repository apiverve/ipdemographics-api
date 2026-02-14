declare module '@apiverve/ipdemographics' {
  export interface ipdemographicsOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface ipdemographicsResponse {
    status: string;
    error: string | null;
    data: IPDemographicsData;
    code?: number;
  }


  interface IPDemographicsData {
      ip:           string;
      location:     Location;
      demographics: Demographics;
      acsYear:      number;
  }
  
  interface Demographics {
      population:            number;
      medianAge:             number;
      medianHouseholdIncome: number;
      perCapitaIncome:       number;
      medianHomeValue:       number;
      collegeEducatedPct:    number;
      unemploymentRate:      number;
      homeOwnershipRate:     number;
  }
  
  interface Location {
      zip:         string;
      city:        string;
      state:       string;
      stateCode:   string;
      country:     string;
      countryCode: string;
      latitude:    number;
      longitude:   number;
      timezone:    string;
  }

  export default class ipdemographicsWrapper {
    constructor(options: ipdemographicsOptions);

    execute(callback: (error: any, data: ipdemographicsResponse | null) => void): Promise<ipdemographicsResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: ipdemographicsResponse | null) => void): Promise<ipdemographicsResponse>;
    execute(query?: Record<string, any>): Promise<ipdemographicsResponse>;
  }
}
