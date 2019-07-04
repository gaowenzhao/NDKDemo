#include "gif.h"

jint restoreSavedState(GifInfo *info, JNIEnv *env, jlongArray state, void *pixels) {
	if (info->gifFilePtr->ImageCount == 1) {
		return -1;
	}

	jlong nativeState[4];
	(*env)->GetLongArrayRegion(env, state, 0, 4, nativeState);

	const uint_fast32_t savedIndex = (uint_fast32_t) nativeState[0];
	const uint_fast8_t savedLoop = (uint_fast8_t) nativeState[1];

	if (savedIndex >= info->gifFilePtr->ImageCount || info->currentLoop > info->loopCount)
		return -1;

	if (savedIndex < info->currentIndex && !reset(info)) {
		info->gifFilePtr->Error = D_GIF_ERR_REWIND_FAILED;
		return -1;
	}

	uint_fast32_t lastFrameDuration = info->controlBlock[info->currentIndex].DelayTime;
	if (info->currentIndex < savedIndex) {
		if (info->currentIndex == 0)
			prepareCanvas(pixels, info);
		while (info->currentIndex < savedIndex) {
			DDGifSlurp(info, true, false);
			lastFrameDuration = getBitmap(pixels, info);
		}
	}

	info->currentLoop = savedLoop;
	info->lastFrameRemainder = nativeState[2];
	memcpy(&info->speedFactor, nativeState + 3, sizeof(info->speedFactor));

	if (info->lastFrameRemainder == -1) {
		uint_fast32_t duration = (uint_fast32_t) (lastFrameDuration * info->speedFactor);
		info->nextStartTime = getRealTime() + duration;
		return (jint) duration;
	}
	return -1;
}





