import CustomBot from "./bot.js";
import Net from 'net';
import Simulation from "./simulation.js";

const port = 8081;
const host = 'localhost';

const client = new Net.Socket();
const bot: CustomBot = new CustomBot();

client.connect({ port: port, host: host }, function() {
  console.log('TCP connection established with the server');

});

client.on('data', function(chunk) {
  const message: string = chunk.toString();
  if (message !== "\n") {
    const sim= JSON.parse(message) as Simulation;
    const action = bot.run(sim);
    client.write((action?.toJSON() ?? "") + "\n");
  }
});

client.on('end', function() {
  console.log('Requested an end to the TCP connection');
});