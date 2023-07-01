class action:
    def to_json(self):
        pass


class move_action(action):
    def __init__(self, pos_x, pos_y):
        self.pos_x = pos_x
        self.pos_y = pos_y
        self.type = "move"

    def to_json(self):
        return f'{{"posX":{self.pos_x},"posY":{self.pos_y},"type":"{self.type}"}}'


class harvest_action(action):
    def __init__(self, station_id):
        self.station_id = station_id
        self.type = "harvest"

    def to_json(self):
        return f'{{"stationId":{self.station_id},"type":"{self.type}"}}'


class sell_action(action):
    def __init__(self):
        self.type = "sell"

    def to_json(self):
        return f'{{"type":"{self.type}"}}'


class end_action(action):
    def __init__(self):
        self.type = "end"

    def to_json(self):
        return f'{{"type":"{self.type}"}}'
