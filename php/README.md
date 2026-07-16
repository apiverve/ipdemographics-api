# IP Demographics API - PHP Package

IP Demographics combines IP geolocation with Census demographic data to provide demographic information for any IP address. Get location, income, education, and housing data based on the IP's geographic location.

## Installation

Install via Composer:

```bash
composer require apiverve/ipdemographics
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Ipdemographics\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute(['ip' => '173.172.81.20']);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Ipdemographics\Client;
use APIVerve\Ipdemographics\Exceptions\APIException;
use APIVerve\Ipdemographics\Exceptions\ValidationException;

try {
    $response = $client->execute(['ip' => '173.172.81.20']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/ipdemographics?utm_source=packagist&utm_medium=readme).

## Support

- Website: [https://apiverve.com/marketplace/ipdemographics?utm_source=php&utm_medium=readme](https://apiverve.com/marketplace/ipdemographics?utm_source=php&utm_medium=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
