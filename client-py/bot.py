import action


class custom_bot:
    def __init__(self):
        self.number_of_harvest = 0
        self.station_id = 0

    def run(self, sim):
        print(sim)
        player = sim.player
        station = sim.stations[self.station_id]

        if station.last_harvested < 20:
            self.station_id += 1
            if self.station_id == 10:
                return action.end_action()
            station = sim.stations[self.station_id]

        if player.payload == 0:
            if player.pos_x == station.pos_x and player.pos_y == station.pos_y:
                self.number_of_harvest = 1
                return action.harvest_action(self.station_id)
            return action.move_action(station.pos_x, station.pos_y)

        if self.number_of_harvest == 3:
            if player.pos_x == 0 and player.pos_y == 0:
                return action.sell_action()
            return action.move_action(0,0)

        self.number_of_harvest += 1
        return action.harvest_action(self.station_id)
