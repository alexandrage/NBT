package ru.minecraft;

import java.util.HashMap;

import ru.minecraft.nbt.JsonToNBT;
import ru.minecraft.nbt.NBTException;
import ru.minecraft.nbt.NBTTagCompound;
import ru.minecraft.nbt.NBTTagList;

public class Main {
    //�������� �����, ��������� ������� ������� � ���������.dat.
	public static void main(String[] args) {
		//����� � ��������.
		String p = "cauldron/world/playerdata"; //���� �� ����� �������.
		//��� ������.
		String UUID = "uuid"; //��� ������.
		//������� � json �������, "Slot:0b" �� ������.
		String Item = 
				  "{"
				+ "id:260s,"
				+ "Damage:0s,"
				+ "Count:1s,"
				+ "Slot:0b,"
				+ "}";
		HashMap<Byte,Byt
		HashMap<Byte,Byte> m = new HashMap<Byte,Byte>();
		OfflineNBT Off = new OfflineNBT(p);
		NBTTagCompound playerNbt = Off.readFromNBT(UUID);
		NBTTagList nbttaglist = playerNbt.getTagList("Inventory", 10);
		System.out.println("������ ���������");
		System.out.println("--------------------------------------------");
		for(int i=0;i<nbttaglist.tagCount();i++) {
			System.out.println(nbttaglist.getCompoundTagAt(i));
			m.put(nbttaglist.getCompoundTagAt(i).getByte("Slot"), nbttaglist.getCompoundTagAt(i).getByte("Slot"));
		}
		if(nbttaglist.tagCount()>35) {
			System.out.println("��� ����� � ���������!");
			return;
		}
		for(int i=0;i<36;i++) {
			if(m.get((byte)i)==null) {
				String s = Item.replace("Slot:0b", "Slot:"+i+"b");
				try {
					nbttaglist.appendTag(JsonToNBT.func_150315_a(s));
				} catch (NBTException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		System.out.println();
		System.out.println("����� ���������");
		System.out.println("--------------------------------------------");
		for(int i=0;i<nbttaglist.tagCount();i++) {
			System.out.println(nbttaglist.getCompoundTagAt(i));
		}
		playerNbt.setTag("Inventory", nbttaglist);
		Off.writeToNBT(UUID, playerNbt);
	}
}