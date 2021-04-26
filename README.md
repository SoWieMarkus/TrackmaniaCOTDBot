# Trackmania COTD Bot

## How does it work?

I am using the the API <a href="trackmania.io">trackmania.io</a> by <a href="https://github.com/codecat">CodeCat</a>. If you want to use this API for your own projects, <a href="https://github.com/codecat">CodeCat</a> allowes the usage of the API under the following conditions:

* The API is unsupported. If CodeCat removes/changes something, CodeCat will (likely) not give notice of it, and you'll have to deal with it yourself.
* The API is undocumented. You're on your own to figure out how the API works and what you need from it.
* Use a proper user agent header so that CodeCat can see how you're using the API.
* There are no hard limitations in place, so please be respectful of CodeCat's server resources as well as Nadeo's. Cache stuff! Please let CodeCat know if you're planning to do any kind of "bulk" requests!
* Let CodeCat know what you're working on! CodeCat is always curious and it lets CodeCat understand how people are using the API and who to contact about certain things if any contact is needed.
* If you're still unsure about your use of the API, feel free to DM Miss#8888 with any further questions.

With the API of trackmania.io I am collecting data about the most recent cup of the day every 10 minutes.

### How to get the results of a cup of the day using the trackmania.io API

The first information I need to get the result of a cup is the `competion id` of the cup

### Get the competition Id

Last update: 27.04.2021

GET `https://trackmania.io/api/cotd/0`

| Name               | Type        | Description       | 
| ------------------ | ----------- | ----------------- | 
| `id`           | long      | Id of the competition. You need this to access the results of the cup. |
| `name`      | String      | Name of the competition. You can extract the date from that. | 
| `players` | long        | Amount of player participating at the cup | 
| `starttime`             | long      | timestamp of the start of the competition |
| `endtime`    | long        | timestamp of the end of the competition  |

```
{
  competitions: [
    {
      id: 344,
      name: "Cup of the Day 2021-04-26",
      players: 2532,
      starttime: 1619457390,
      endtime: 1619464590
    },
    {
      id: 343,
      name: "Cup of the Day 2021-04-25",
      players: 2275,
      starttime: 1619370990,
      endtime: 1619378190
    },
  ...
  ]
}
```

The collected data will be sent to my <a href="https://github.com/SoWieMarkus/TrackmaniaCOTDRestAPI">Trackmania COTD Rest API</a>. There the leaderboard will be calculated. The  <a href="https://github.com/SoWieMarkus/TrackmaniaCOTDApp">Trackmania App for Android</a> will access the leaderboards via that API.
