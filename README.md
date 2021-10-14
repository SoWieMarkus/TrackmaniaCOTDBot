# Trackmania COTD Bot

This project is a bot to harvest the results of the cup of the days.

## How does it work?

Last update: 27.04.2021

I am using the API of <a href="trackmania.io">trackmania.io</a> by <a href="https://github.com/codecat">CodeCat</a>. If you want to use this API for your own projects, <a href="https://github.com/codecat">CodeCat</a> allowes the usage of the API under the following conditions:

* The API is unsupported. If CodeCat removes/changes something, CodeCat will (likely) not give notice of it, and you'll have to deal with it yourself.
* The API is undocumented. You're on your own to figure out how the API works and what you need from it.
* Use a proper user agent header so that CodeCat can see how you're using the API.
* There are no hard limitations in place, so please be respectful of CodeCat's server resources as well as Nadeo's. Cache stuff! Please let CodeCat know if you're planning to do any kind of "bulk" requests!
* Let CodeCat know what you're working on! CodeCat is always curious and it lets CodeCat understand how people are using the API and who to contact about certain things if any contact is needed.
* If you're still unsure about your use of the API, feel free to DM Miss#8888 with any further questions.

With the API of trackmania.io I am collecting data about the most recent cup of the day every 10 minutes.

### How to get the results of a cup of the day using the trackmania.io API

The first information I need to get the result of a cup is the `competition id` of the cup

### Get the competition Id

GET `https://trackmania.io/api/cotd/<page>`

* Example: <a href="https://trackmania.io/api/cotd/0">Latest COTD's</a>

CodeCat has a nice feature to page the results. The `page` parameter can be any number bigger or equal to zero. If you call `https://trackmania.io/api/cotd/0` you will get the first (normally) 25 results. If you need more information you can call `https://trackmania.io/api/cotd/1` afterwards to get the next 25 results.

| Name               | Type        | Description       | 
| ------------------ | ----------- | ----------------- | 
| `id`           | long      | Id of the competition. You need this to access the results of the cup. |
| `name`      | String      | Name of the competition. You can extract the date from that. Also the #<number> gives information about which of the three cotds of a day. | 
| `players` | long        | Amount of player participating at the cup | 
| `starttime`             | long      | timestamp of the start of the competition |
| `endtime`    | long        | timestamp of the end of the competition  |

```javascript
{
  competitions: [
    {
     id: 1164,
     name: "Cup of the Day 2021-10-14 #3",
     players: 0,
     starttime: 1634289390,
     endtime: 1634296590
    },
    {
     id: 1163,
     name: "Cup of the Day 2021-10-14 #2",
     players: 0,
     starttime: 1634260590,
     endtime: 1634267790
    },
    {
      id: 1162,
      name: "Cup of the Day 2021-10-14 #1",
      players: 2537,
      starttime: 1634231790,
      endtime: 1634238990
     },
  ...
  ]
}
```

With that competition Id we can query the actual competition behind the cup of the day.

### Get the competition behind the cup of the day

GET `https://trackmania.io/api/comp/<competitionId>`
  
* Example: <a href="https://trackmania.io/api/comp/1162">COTD with competitionId 1162</a>
  
```javascript
{
  id: 344,
  numplayers: 2532,
  liveid: "LID-COMP-oyportjala2mm5p",
  creatorplayer: {
    name: "Nadeo",
    id: "afe7e1c1-7086-48f7-bde9-a7e320647510",
    meta: {
      vanity: "nadeo2",
      comment: "This is a secondary Nadeo system account that authors COTD competitions.",
      mainaccount: "d2372a08-a8a1-46cb-97fb-23a161d85ad0",
      nadeo: true
    }
  },
  name: "Cup of the Day 2021-04-26",
  description: "",
  registrationstart: 0,
  registrationend: 0,
  startdate: 1619457390,
  enddate: 1619464590,
  leaderboardid: 1179,
  manialink: "",
  rulesurl: "",
  streamurl: "",
  websiteurl: "",
  logourl: "",
  verticalurl: "",
  rounds: [
    {
      id: 645,
      name: "Round",
      status: "COMPLETED",
      matches: [
        {
          id: 5163,
          name: "Match 1",
          completed: true
        },
        {
          id: 5164,
          name: "Match 2",
          completed: true
        },
        ...
      ]
    }
  ],
  challenges: [
    {
      id: 606,
      name: "Qualifier"
    }
  ]
}
```

Many information ^^. For this project the interesting data is only the `id` of the first match and the `status` of the first round. Because only players from division one can qualify for the leaderboard we can ignore the other matches. Also the status of the first round is important to check if there are already results for the cup. If `status` is not equal to `COMPLETED` the bot will come back later.

### Get the results of the cup of the day

GET `https://trackmania.io/api/comp/<competionId>/match/<matchId>/<page>`
  
  * Example: <a href="https://trackmania.io/api/comp/1162/match/15391/0">First 25 players of Match 1</a>

```javascript
{
  results: [
    {
      accountid: "fb678553-f730-442a-a035-dfc50f4a5b7b",
      displayname: "mime..",
      zone: {
        name: "Dolnośląskie",
        flag: "dolnoslaskie",
        parent: {
          name: "Poland",
          flag: "POL",
          parent: {
            name: "Europe",
            flag: "europe",
            parent: {
              name: "World",
              flag: "WOR"
            }
          }
        }
      },
      position: 1,
      score: 54
    },
    ...
  ]
}
```

*IMPORTANT* The score returned by this call is NOT the score used in the leaderboard!

The collected data will be sent to my <a href="https://github.com/SoWieMarkus/TrackmaniaCOTDRestAPI">Trackmania COTD Rest API</a>. There the leaderboard will be calculated. The  <a href="https://github.com/SoWieMarkus/TrackmaniaCOTDApp">Trackmania App for Android</a> will access the leaderboards via that API.
