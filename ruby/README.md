# IP Demographics API - Ruby Gem

IP Demographics combines IP geolocation with Census demographic data to provide demographic information for any IP address. Get location, income, education, and housing data based on the IP's geographic location. Demographics cover US ZIP codes; other locations return the location with demographics set to null.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_ipdemographics'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_ipdemographics
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_ipdemographics'

# Initialize the client
client = APIVerve::Ipdemographics::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({ ip: "173.172.81.20" })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ ip: "173.172.81.20" })
  puts response["data"]
rescue APIVerve::Ipdemographics::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Ipdemographics::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Ipdemographics::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/ipdemographics?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/ipdemographics?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/ipdemographics?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
