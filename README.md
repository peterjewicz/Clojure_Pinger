# pinger

A simple application that pings a list of sites to check they're active and records the results to a DB

## Installation

Clone this repo. Upload the DB file to MySQL and populate with sites.


Then run from the project directory

lein run



## Usage

Spawns multiple threads where each ping check is farmed out to an individual thread.

### Bugs
