import asyncio
import json
import bot
import simulation
import action

PORT = 8081
HOST = "localhost"


async def tcp_client():
    reader, writer = await asyncio.open_connection(HOST, PORT)
    print("TCP connection established with the server")
    runner = bot.custom_bot()
    while 1:
        json_string = (await reader.readline()).decode("utf-8").replace(":", ": ").replace(",", ", ")
        if json_string == "\n":
            writer.close()
            await writer.wait_closed()
            break

        sim = simulation.create_simulation(json.loads(json_string))
        act = runner.run(sim)
        json_ret = ""
        if act != 0:
            json_ret = act.to_json()

        writer.write(f"{json_ret}\n".encode("utf-8"))
    print("Requested an end to the TCP connection")


if __name__ == '__main__':
    asyncio.run(tcp_client())
