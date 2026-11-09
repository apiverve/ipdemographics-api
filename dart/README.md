# IP Demographics API - Dart/Flutter Client

IP Demographics combines IP geolocation with Census demographic data to provide demographic information for any IP address. Get location, income, education, and housing data based on the IP's geographic location. Demographics cover US ZIP codes; other locations return the location with demographics set to null.

[![pub package](https://img.shields.io/pub/v/apiverve_ipdemographics.svg)](https://pub.dev/packages/apiverve_ipdemographics)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [IP Demographics API](https://apiverve.com/marketplace/ipdemographics?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_ipdemographics: ^1.2.5
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_ipdemographics/apiverve_ipdemographics.dart';

void main() async {
  final client = IpdemographicsClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'ip': '173.172.81.20'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "ip": "8.8.8.8",
    "location": {
      "zip": "94043",
      "city": "Mountain View",
      "state": "California",
      "stateCode": "CA",
      "country": "United States",
      "countryCode": "US",
      "latitude": 37.4056,
      "longitude": -122.0775,
      "timezone": "America/Los_Angeles"
    },
    "demographics": {
      "population": 81234,
      "medianAge": 34.5,
      "medianHouseholdIncome": 142567,
      "perCapitaIncome": 78234,
      "medianHomeValue": 1875000,
      "collegeEducatedPct": 68.3,
      "unemploymentRate": 3.2,
      "homeOwnershipRate": 45.6
    },
    "acsYear": 2022,
    "formatted": {
      "medianHouseholdIncome": "$142,567",
      "perCapitaIncome": "$78,234",
      "medianHomeValue": "$1,875,000"
    }
  }
}
```

## API Reference

- **API Home:** [IP Demographics API](https://apiverve.com/marketplace/ipdemographics?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/ipdemographics](https://docs.apiverve.com/ref/ipdemographics?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
