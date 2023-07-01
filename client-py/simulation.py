class player:
    def __init__(self, pos_x, pos_y, payload, money):
        self.pos_x = pos_x
        self.pos_y = pos_y
        self.payload = payload
        self.money = money

    def __str__(self):
        return f"({self.pos_x},{self.pos_y}) {self.payload} {self.money}"


class station:
    def __init__(self, pos_x, pos_y, last_harvested, station_id):
        self.pos_x = pos_x
        self.pos_y = pos_y
        self.last_harvested = last_harvested
        self.station_id = station_id

    def __str__(self):
        return f"{self.station_id} = ({self.pos_x},{self.pos_y}) {self.last_harvested}"


class simulation:
    def __init__(self, p, stations):
        self.player = p
        self.stations = stations

    def __str__(self):
        stations = '\n\t'.join([str(s) for s in self.stations])
        return f"Simulation:\n\t{str(self.player)}\n\t{stations}"


def create_simulation(json):
    s = json["stations"]
    stations = [station(i["posX"], i["posY"], i["lastHarvested"], i["id"]) for i in s]
    p = json["player"]
    pl = player(p["posX"], p["posY"], p["payload"], p["money"])
    return simulation(pl, stations)
