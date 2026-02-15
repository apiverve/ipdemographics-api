using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.IPDemographics
{
    /// <summary>
    /// Query options for the IP Demographics API
    /// </summary>
    public class IPDemographicsQueryOptions
    {
        /// <summary>
        /// IPv4 or IPv6 address
        /// </summary>
        [JsonProperty("ip")]
        public string Ip { get; set; }
    }
}
