https://github.com/NicolasJRuax/Transporte.git

# Transporte Público App

**Transporte Público App** es una aplicación Android diseñada para facilitar el uso del transporte público. Permite a los usuarios seleccionar líneas de autobús y metro, consultar paradas, visualizar el tiempo restante para la llegada del próximo transporte, y recibir notificaciones sobre paradas fuera de servicio.

---

## **Características Principales**

1. **Selección de Transporte**:
   - Los usuarios pueden elegir entre **autobús** y **metro** desde una pantalla inicial.
   - Cada transporte incluye varias líneas específicas disponibles para selección.

2. **Consulta de Paradas**:
   - Para cada línea, se pueden visualizar las paradas asociadas.
   - Algunas paradas estarán  "Fuera de Servicio" .

3. **Información en Tiempo Real**:
   - Tiempo restante para la llegada del próximo transporte.
   - Las paradas fuera de servicio muestran una advertencia específica.

4. **Gestión Dinámica**:
   - Uso de listas dinámicas para mostrar las paradas.
   - Generación de tiempos y estados para simular datos en tiempo real.

---

## **Clases y Relación Entre Ellas**

### 1. **`MainActivity`**
- **Función**:
  - Es la pantalla principal de la aplicación.
  - Permite a los usuarios elegir entre transporte **autobús** y **metro**.
- **Detalles Técnicos**:
  - Contiene botones para cada transporte que abren una nueva actividad (`TransportActivity`) con las líneas correspondientes.
- **Relaciones**:
  - Llama a `TransportActivity` para mostrar las líneas disponibles.

---

### 2. **`TransportActivity`**
- **Función**:
  - Muestra las líneas disponibles para el transporte seleccionado (metro o autobús).
- **Detalles Técnicos**:
  - Usa una lista (`ListView`) para mostrar las líneas asociadas.
  - Al hacer clic en una línea, abre la actividad `StopActivity` para mostrar las paradas correspondientes.
- **Relaciones**:
  - Recibe datos de `MainActivity`.
  - Llama a `StopActivity` con información sobre la línea seleccionada.

---

### 3. **`StopActivity`**
- **Función**:
  - Muestra las paradas asociadas a una línea seleccionada.
  - Simula el tiempo restante para la llegada del transporte y marca algunas paradas como "Fuera de Servicio".
- **Detalles Técnicos**:
  - Genera una lista dinámica de paradas.
  - Utiliza un generador para:
    - Marcar dos paradas como "Fuera de Servicio".
    - Generar un tiempo de llegada aleatorio para cada parada activa.
  - Muestra mensajes en forma de `Toast` según el estado de la parada seleccionada.
- **Relaciones**:
  - Recibe la línea seleccionada desde `TransportActivity`.
  - Gestiona y presenta las paradas asociadas a esa línea.

---

## **Flujo de la Aplicación**

1. **Inicio en `MainActivity`**:
   - Los usuarios eligen entre autobús y metro.
   - Según la selección, se abre `TransportActivity`.

2. **Selección de Línea en `TransportActivity`**:
   - Muestra las líneas disponibles para el transporte seleccionado.
   - Al seleccionar una línea, se abre `StopActivity`.

3. **Consulta de Paradas en `StopActivity`**:
   - Se presenta una lista de paradas.
   - Los usuarios pueden hacer clic en una parada para ver el tiempo restante o ser notificados si está fuera de servicio.

---

## **Estructura del Proyecto**

```plaintext
src/
├── MainActivity.java        # Pantalla inicial: selección de transporte
├── TransportActivity.java   # Muestra las líneas disponibles por transporte
├── StopActivity.java        # Lista de paradas y simulación de tiempos
res/
├── layout/
│   ├── activity_main.xml        # Diseño de MainActivity
│   ├── activity_transport.xml   # Diseño de TransportActivity
│   ├── activity_stop.xml        # Diseño de StopActivity
├── values/
│   ├── strings.xml              # Cadenas de texto utilizadas en la aplicación
├── AndroidManifest.xml          # Configuración de las actividades
