package com.fortythirtygames.rebelliongamehelper.model


enum class BaseDiscoveryState {
    Unknown,
    Probed,
    Occupied,
    Discovered
}

enum class GalacticSystem(var baseState: BaseDiscoveryState) {
    // Northwest region
    MonCalamari(BaseDiscoveryState.Unknown),
    Yavin(BaseDiscoveryState.Unknown),
    Felucia(BaseDiscoveryState.Unknown),
    Saleucami(BaseDiscoveryState.Unknown),
    // Southwest region
    Dantooine(BaseDiscoveryState.Unknown),
    Mygeeto(BaseDiscoveryState.Unknown),
    Ilum(BaseDiscoveryState.Unknown),
    OrdMantell(BaseDiscoveryState.Unknown),
    // Northern region
    Kessel(BaseDiscoveryState.Unknown),
    NalHutta(BaseDiscoveryState.Unknown),
    Toydaria(BaseDiscoveryState.Unknown),
    Bothawui(BaseDiscoveryState.Unknown),
    // Central region
    Mandalore(BaseDiscoveryState.Unknown),
    Kashyyyyk(BaseDiscoveryState.Unknown),
    Malastare(BaseDiscoveryState.Unknown),
    // Core region
    Alderaan(BaseDiscoveryState.Unknown),
    CatoNeimoidia(BaseDiscoveryState.Unknown),
    Corellia(BaseDiscoveryState.Unknown),
    Coruscant(BaseDiscoveryState.Unknown),
    // Northeast region
    Tatooine(BaseDiscoveryState.Unknown),
    Ryloth(BaseDiscoveryState.Unknown),
    Rodia(BaseDiscoveryState.Unknown),
    Geonosis(BaseDiscoveryState.Unknown),
    // Eastern region
    Naboo(BaseDiscoveryState.Unknown),
    Utapau(BaseDiscoveryState.Unknown),
    Dagobah(BaseDiscoveryState.Unknown),
    Sullust(BaseDiscoveryState.Unknown),
    // Southeast region
    Mustafar(BaseDiscoveryState.Unknown),
    Bespin(BaseDiscoveryState.Unknown),
    Hoth(BaseDiscoveryState.Unknown),
    Endor(BaseDiscoveryState.Unknown), ;

    /**
     * Switch this system's base discovery to the next state.
     */
    fun toggleState() {
        this.baseState = when (this.baseState) {
            BaseDiscoveryState.Unknown -> BaseDiscoveryState.Occupied
            BaseDiscoveryState.Occupied -> BaseDiscoveryState.Probed
            BaseDiscoveryState.Probed -> BaseDiscoveryState.Discovered
            BaseDiscoveryState.Discovered -> BaseDiscoveryState.Unknown
        }
    }
}