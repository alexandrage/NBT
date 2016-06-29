package ru.minecraft;

import ru.minecraft.nbt.NBTTagCompound;

public class setGameMode {
    //Тестовый класс, изменяет GameMode в инвентарь.dat.
	public static void main(String[] args) {
		//Папка с игроками.
		String p = "cauldron/world/playerdata"; //Путь до папки игроков.
		//Уид игрока.
		String UUID = "uuid"; //Уид игрока.
		OfflineNBT Off = new OfflineNBT(p);
		NBTTagCompound playerNbt = Off.readFromNBT(UUID);
		playerNbt.setInteger("playerGameType", 0);
		Off.writeToNBT(UUID, playerNbt);
	}
}
