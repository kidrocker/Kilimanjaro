package com.dvt.domain.useCase

import com.dvt.domain.repository.sync.DataSyncRepository
import javax.inject.Inject

class SyncDataUseCase @Inject constructor(
    private val dataSyncRepository: DataSyncRepository
) {
    suspend operator fun invoke (lat:String, lng:String){
        dataSyncRepository.syncHomeData(lat,lng)
    }
}