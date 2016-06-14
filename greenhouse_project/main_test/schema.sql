create table if not exists 'indoor'(
	id integer primary key autoincrement,
	node_number text not null,
	update_time text not null,
	temperature text not null,
	humidity text not null,
	radiation text not null,
	co2 text not null
);

create table if not exists 'outdoor'(
	id integer primary key autoincrement,
	update_time text not null,
	temperature text not null,
	humidity text not null,
	radiation text not null,
	co2 text not null,
	wind_direction text not null,
	wind_speed text not null,
	rain_snow text not null,
	atmosphere text not null
);

create table if not exists 'control_state'(
	id integer primary key autoincrement,
	update_time text not null,
	roof_vent_south text not null,
	roof_vent_north text not null,
	side_vent text not null,
	shade_screen_out text not null,
	shade_screen_in text not null,
	thermal_screen text not null,
	cooling_pad text not null,
	fogging text not null,
	heating text not null,
	co2 text not null,
	lighting_1 text not null,
	lighting_2 text not null,
	irrigation text not null
);