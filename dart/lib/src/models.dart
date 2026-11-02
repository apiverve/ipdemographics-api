/// Response models for the IP Demographics API.

/// API Response wrapper.
class IpdemographicsResponse {
  final String status;
  final dynamic error;
  final IpdemographicsData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  IpdemographicsResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory IpdemographicsResponse.fromJson(Map<String, dynamic> json) => IpdemographicsResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? IpdemographicsData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the IP Demographics API.

class IpdemographicsData {
  String? ip;
  IpdemographicsDataLocation? location;
  IpdemographicsDataDemographics? demographics;
  num? acsYear;
  IpdemographicsDataFormatted? formatted;

  IpdemographicsData({
    this.ip,
    this.location,
    this.demographics,
    this.acsYear,
    this.formatted,
  });

  factory IpdemographicsData.fromJson(Map<String, dynamic> json) => IpdemographicsData(
      ip: json['ip'],
      location: json['location'] != null ? IpdemographicsDataLocation.fromJson(json['location']) : null,
      demographics: json['demographics'] != null ? IpdemographicsDataDemographics.fromJson(json['demographics']) : null,
      acsYear: json['acsYear'],
      formatted: json['formatted'] != null ? IpdemographicsDataFormatted.fromJson(json['formatted']) : null,
    );
}

class IpdemographicsDataLocation {
  String? zip;
  String? city;
  String? state;
  String? stateCode;
  String? country;
  String? countryCode;
  num? latitude;
  num? longitude;
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
  num? population;
  num? medianAge;
  num? medianHouseholdIncome;
  num? perCapitaIncome;
  num? medianHomeValue;
  num? collegeEducatedPct;
  num? unemploymentRate;
  num? homeOwnershipRate;

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

class IpdemographicsDataFormatted {
  String? medianHouseholdIncome;
  String? perCapitaIncome;
  String? medianHomeValue;

  IpdemographicsDataFormatted({
    this.medianHouseholdIncome,
    this.perCapitaIncome,
    this.medianHomeValue,
  });

  factory IpdemographicsDataFormatted.fromJson(Map<String, dynamic> json) => IpdemographicsDataFormatted(
      medianHouseholdIncome: json['medianHouseholdIncome'],
      perCapitaIncome: json['perCapitaIncome'],
      medianHomeValue: json['medianHomeValue'],
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
