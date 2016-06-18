package ru.minecraft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import ru.minecraft.nbt.CompressedStreamTools;
import ru.minecraft.nbt.NBTTagCompound;

public class OfflineNBT {

	String playerdata;
	public OfflineNBT(String string) {
		playerdata = string;
	}

	public NBTTagCompound readFromNBT(String UUID){
		NBTTagCompound playerNbt;
		try {
			File playersDirectory = new File(playerdata);
			File playerFile = new File(playersDirectory, UUID + ".dat");
			playerNbt = CompressedStreamTools.readCompressed(new FileInputStream(playerFile));
			if(playerNbt==null){
				System.out.println("playernbt is null");
			}
			return playerNbt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("RETURNED NULL");
		return null;
	}
	
	public void writeToNBT(String UUID, NBTTagCompound playerNbt){
		try {
			File playersDirectory = new File(playerdata);
			File playerFile = new File(playersDirectory, UUID + ".dat");
			CompressedStreamTools.writeCompressed(playerNbt, new FileOutputStream(playerFile));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}