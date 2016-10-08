package com.fortythirtygames.rebelliongamehelper

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ctc.android.widget.ImageMap

/**
 * Created by Ron on 9/24/2016.
 */
class GalacticMapFragment : Fragment() {

    private lateinit var imageMap: ImageMap

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater?.inflate(R.layout.fragment_galactic_map, container, false)

        imageMap = view?.findViewById(R.id.image_map) as ImageMap
        imageMap.addOnImageMapClickedHandler(object : ImageMap.OnImageMapClickedHandler {
            override fun onImageMapClicked(areaId: Int, map: ImageMap?) {
                map?.showBubble("Occupied", areaId)
            }

            override fun onBubbleClicked(areaId: Int) {
                // TODO: Change handling
                imageMap
            }
        })

        return view
    }
}