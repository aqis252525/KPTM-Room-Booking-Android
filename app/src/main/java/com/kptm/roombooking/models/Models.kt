package com.kptm.roombooking.models

data class User(
    val id: Int,
    val name: String,
    val semester: String,
    val profile: String,
    val studentId: String,
    val ic: String,
    val className: String,
    val email: String
)

data class Booking(
    val id: Int,
    val userId: Int,
    val roomId: Int,
    val roomName: String,
    val bookingDate: String,
    val startTime: String,
    val endTime: String,
    val status: String
)

data class MaintenanceRequest(
    val id: Int,
    val category: String,
    val description: String,
    val roomNumber: String,
    val status: String,
    val createdDate: String
)

data class ApprovalNotification(
    val id: Int,
    val type: String,
    val message: String,
    val isRead: Boolean,
    val timestamp: String
)

data class Room(
    val id: Int,
    val name: String,
    val type: String,
    val capacity: Int
)
