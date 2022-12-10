package com.parbatSubedi.springBoot.Dto;

public class UserUpdateDto extends UserCreateDto {
	
	private static long serialVersionUID = 1L;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		UserUpdateDto.serialVersionUID = serialVersionUID;
	}

}
