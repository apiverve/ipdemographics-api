/// Response models for the IP Demographics API.

/// API Response wrapper.
class IpdemographicsResponse {
  final String status;
  final dynamic error;
  final IpdemographicsData? data;

  IpdemographicsResponse({
    required this.status,
    this.error,
    this.data,
  });

  factory IpdemographicsResponse.fromJson(Map<String, dynamic> json) => IpdemographicsResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? IpdemographicsData.fromJson(json['data']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
  };
}

/// Response data for the IP Demographics API.

class IpdemographicsData {
  String? ip;
  IpdemographicsDataLocation? location;
  IpdemographicsDataDemographics? demographics;
  int? acsYear;

  IpdemographicsData({
    this.ip,
    this.location,
    this.demographics,
    this.acsYear,
  });

  factory IpdemographicsData.fromJson(Map<String, dynamic> json) => IpdemographicsData(
      ip: json['ip'],
      location: json['location'] != null ? IpdemographicsDataLocation.fromJson(json['location']) : null,
      demographics: json['demographics'] != null ? IpdemographicsDataDemographics.fromJson(json['demographics']) : null,
      acsYear: json['acsYear'],
    );
}

class IpdemographicsDataLocation {
  String? zip;
  String? city;
  String? state;
  String? stateCode;
  String? country;
  String? countryCode;
  double? latitude;
  double? longitude;
  String? timezone;

  IpdemographicsDataLocation({
    this.zip,
    this.city,
    this.state,
    this.stateCode,
    this.country,
    this.countryCode,
    this.latitude,
    this.longitude,
    this.timezone,
  });

  factory IpdemographicsDataLocation.fromJson(Map<String, dynamic> json) => IpdemographicsDataLocation(
      zip: json['zip'],
      city: json['city'],
      state: json['state'],
      stateCode: json['stateCode'],
      country: json['country'],
      countryCode: json['countryCode'],
      latitude: json['latitude'],
      longitude: json['longitude'],
      timezone: json['timezone'],
    );
}

class IpdemographicsDataDemographics {
  int? population;
  double? medianAge;
  int? medianHouseholdIncome;
  int? perCapitaIncome;
  int? medianHomeValue;
  double? collegeEducatedPct;
  double? unemploymentRate;
  double? homeOwnershipRate;

  IpdemographicsDataDemographics({
    this.population,
    this.medianAge,
    this.medianHouseholdIncome,
    this.perCapitaIncome,
    this.medianHomeValue,
    this.collegeEducatedPct,
    this.unemploymentRate,
    this.homeOwnershipRate,
  });

  factory IpdemographicsDataDemographics.fromJson(Map<String, dynamic> json) => IpdemographicsDataDemographics(
      population: json['population'],
      medianAge: json['medianAge'],
      medianHouseholdIncome: json['medianHouseholdIncome'],
      perCapitaIncome: json['perCapitaIncome'],
      medianHomeValue: json['medianHomeValue'],
      collegeEducatedPct: json['collegeEducatedPct'],
      unemploymentRate: json['unemploymentRate'],
      homeOwnershipRate: json['homeOwnershipRate'],
    );
}

class IpdemographicsRequest {
  String ip;

  IpdemographicsRequest({
    required this.ip,
  });

  Map<String, dynamic> toJson() => {
      'ip': ip,
    };
}
