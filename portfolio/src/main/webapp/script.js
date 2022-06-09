// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Collapsible Buttons.
 */
var coll = document.getElementsByClassName("collapsibleTitle");
var i;
for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}

/**
 * Random quotes generator
 * Prints out the random quotes
 */
async function getQuote() {
    const responseFromServer = await fetch('/hello');
    const arrayQuotes = await responseFromServer.json();
    const randomQuote = randomQuoteGenerator(arrayQuotes)  //get a random quote
    const quotesContainer = document.getElementById('quotes');
    quotesContainer.innerText = randomQuote;
  }

/**
 * for generating a random quote
 * @param {*} quotes is the object with quotes
 */
  function randomQuoteGenerator(quotes) {
    const max = 2;
    const min = 0;
    const i = Math.floor(Math.random()*(max-min+1)+min); //random number between 0 and 2
    const randomQuote = quotes[i];
    return randomQuote;
}
