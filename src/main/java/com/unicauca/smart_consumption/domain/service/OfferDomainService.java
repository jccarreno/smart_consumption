package com.unicauca.smart_consumption.domain.service;

import com.unicauca.smart_consumption.domain.model.Offer;
import com.unicauca.smart_consumption.domain.model.Store;

import java.util.ArrayList;
import java.util.List;

public class OfferDomainService {
    /**
     * Activa una oferta en una tienda específica si la oferta es válida.
     *
     * @param tienda La tienda donde se activará la oferta.
     * @param oferta La oferta que se va a activar.
     */
    public void activarOfertaEnTienda(Store tienda, Offer oferta) {
        if (!esOfertaValida(oferta)) {
            throw new IllegalArgumentException("La oferta no es válida.");
        }
        if (tienda.tieneOfertaActiva(oferta)) {
            throw new IllegalArgumentException("La oferta ya está activa en la tienda.");
        }
        tienda.agregarOferta(oferta);
    }

    /**
     * Obtiene todas las ofertas activas en una tienda específica que aplican un descuento mayor al umbral.
     *
     * @param tienda   La tienda de la cual se quieren obtener las ofertas.
     * @param umbral   El umbral de descuento mínimo para filtrar ofertas.
     * @return Una lista de ofertas activas que cumplen con el umbral.
     */
    public List<Offer> obtenerOfertasConDescuento(Store tienda, double umbral) {
        List<Offer> ofertas = tienda.getOfertas();
        List<Offer> ofertasFiltradas = new ArrayList<>();
        for (Offer oferta : ofertas) {
            if (oferta.getPorcentage() > umbral) {
                ofertasFiltradas.add(oferta);
            }
        }
        return ofertasFiltradas;

    }

    /**
     * Verifica si una oferta es válida.
     *
     * @param oferta La oferta a verificar.
     * @return true si la oferta es válida, false en caso contrario.
     */
    private boolean esOfertaValida(Offer oferta) {
        return oferta.getPorcentage() >= 0 && oferta.getPorcentage() <= 100;
    }
}
